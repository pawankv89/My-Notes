package com.pk.mynotes.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.pk.mynotes.R;
import com.pk.mynotes.models.Note;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class NotesListFragmentDirections {
  private NotesListFragmentDirections() {
  }

  @NonNull
  public static ActionAddNewNoteToEditNoteFragment2 actionAddNewNoteToEditNoteFragment2() {
    return new ActionAddNewNoteToEditNoteFragment2();
  }

  public static class ActionAddNewNoteToEditNoteFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAddNewNoteToEditNoteFragment2() {
    }

    @NonNull
    public ActionAddNewNoteToEditNoteFragment2 setNote(@Nullable Note Note) {
      this.arguments.put("Note", Note);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Note")) {
        Note Note = (Note) arguments.get("Note");
        if (Parcelable.class.isAssignableFrom(Note.class) || Note == null) {
          __result.putParcelable("Note", Parcelable.class.cast(Note));
        } else if (Serializable.class.isAssignableFrom(Note.class)) {
          __result.putSerializable("Note", Serializable.class.cast(Note));
        } else {
          throw new UnsupportedOperationException(Note.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_addNewNote_to_editNoteFragment2;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Note getNote() {
      return (Note) arguments.get("Note");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAddNewNoteToEditNoteFragment2 that = (ActionAddNewNoteToEditNoteFragment2) object;
      if (arguments.containsKey("Note") != that.arguments.containsKey("Note")) {
        return false;
      }
      if (getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAddNewNoteToEditNoteFragment2(actionId=" + getActionId() + "){"
          + "Note=" + getNote()
          + "}";
    }
  }
}
