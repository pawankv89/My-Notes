package com.pk.mynotes.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.pk.mynotes.R;

public class EditNoteFragmentDirections {
  private EditNoteFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionEditNoteFragment2ToAddNewNote() {
    return new ActionOnlyNavDirections(R.id.action_editNoteFragment2_to_addNewNote);
  }
}
