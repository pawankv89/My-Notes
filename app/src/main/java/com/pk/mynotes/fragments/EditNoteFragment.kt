package com.pk.mynotes.fragments


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.pk.mynotes.R
import com.pk.mynotes.db.NotesDatabase
import com.pk.mynotes.models.Note
import com.pk.mynotes.utils.getCurrenDate
import com.pk.mynotes.utils.hideSoftKeyboard
import com.pk.mynotes.utils.toast
import kotlinx.android.synthetic.main.fragment_edit_note.*
import kotlinx.android.synthetic.main.note_item.note_title
import kotlinx.coroutines.launch
import java.util.logging.Logger


class EditNoteFragment : BaseFragment() {

    private var note: Note ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_note, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
            setDisplayHomeAsUpEnabled(true)
            title = "Add Note"

            arguments?.let {
                note = EditNoteFragmentArgs.fromBundle(it).note

                Logger.getLogger("note_title").warning(note?.text)
                note_title.text = note?.tilte
                note_content.setText(note?.text)
                title = "Edit Note Details"
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.note_details_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_share -> {

                val noteTitle: String = note_title.text.toString().trim()

                if (noteTitle.isEmpty()){
                    note_title.error = "This is required"
                    note_title.requestFocus()
                    return false
                }

                Toast.makeText(context, "Share Note", Toast.LENGTH_SHORT).show()

                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, noteTitle); //"This is my Note to send."
                startActivity(shareIntent)
            }

            R.id.menu_github ->{

                Toast.makeText(context, "Open on Github", Toast.LENGTH_SHORT).show()

                var url = "https://github.com/pawankv89/My-Notes.git"
                val uris = Uri.parse(url)
                val intents = Intent(Intent.ACTION_VIEW, uris)
                startActivity(intents)
            }

            R.id.menu_save ->{

                hideSoftKeyboard(activity!!, view!!)

                val noteTitle: String = note_title.text.toString().trim()

                if (noteTitle.isEmpty()){
                    note_title.error = "This is required"
                    note_title.requestFocus()
                    return false
                }

                val noteContent: String = note_content.text.toString().trim()

                if (noteContent.isEmpty()){
                    note_content.error = "This is required"
                    note_content.requestFocus()
                    return false
                }


                        launch {
                            val updatedNote = Note(noteTitle,
                                noteContent,
                                getCurrenDate(),
                                false,
                                System.currentTimeMillis())


                            context?.let {

                                if (note == null) {
                                    NotesDatabase.invoke(it)
                                        .notesDao()
                                        .newNote(updatedNote)
                                    it.toast("Note saved")
                                }

                                else{
                                    updatedNote.id = note!!.id
                                    NotesDatabase.invoke(it).notesDao().updateNote(updatedNote)
                                    it.toast("Note updated")
                                }

                                val action = EditNoteFragmentDirections.actionEditNoteFragment2ToAddNewNote()
                                Navigation.findNavController(view!!).navigate(action)
                            }
                        }
            }

            R.id.menu_delete -> run {
                hideSoftKeyboard(activity!!, view!!)

                if (note == null){
                    context?.toast("Cannot delete empty note")
                }

                else
                note?.let { deleteNote(it) }

            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun deleteNote(note: Note) {

        AlertDialog.Builder(context!!).apply {
            setMessage("Are you sure you want to Delete note?")
            setPositiveButton("YES"){ dialogInterface, i ->
                run {
                    launch {
                        NotesDatabase.invoke(context!!)
                            .notesDao()
                            .delete(note)
                        dialogInterface.dismiss()
                        context!!.toast("deleted")

                        val action = EditNoteFragmentDirections.actionEditNoteFragment2ToAddNewNote()
                        Navigation.findNavController(view!!).navigate(action)
                    }
                }
            }

            setNegativeButton("NO"){dialogInterface, i ->
                dialogInterface.dismiss()
            }
            show()
        }

    }


}
