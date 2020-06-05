package com.pk.mynotes.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.pk.mynotes.models.Note;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class EditNoteFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private EditNoteFragmentArgs() {
  }

  private EditNoteFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static EditNoteFragmentArgs fromBundle(@NonNull Bundle bundle) {
    EditNoteFragmentArgs __result = new EditNoteFragmentArgs();
    bundle.setClassLoader(EditNoteFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Note")) {
      Note Note;
      if (Parcelable.class.isAssignableFrom(Note.class) || Serializable.class.isAssignableFrom(Note.class)) {
        Note = (Note) bundle.get("Note");
      } else {
        throw new UnsupportedOperationException(Note.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("Note", Note);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Note getNote() {
    return (Note) arguments.get("Note");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    EditNoteFragmentArgs that = (EditNoteFragmentArgs) object;
    if (arguments.containsKey("Note") != that.arguments.containsKey("Note")) {
      return false;
    }
    if (getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "EditNoteFragmentArgs{"
        + "Note=" + getNote()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(EditNoteFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public EditNoteFragmentArgs build() {
      EditNoteFragmentArgs result = new EditNoteFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setNote(@Nullable Note Note) {
      this.arguments.put("Note", Note);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Note getNote() {
      return (Note) arguments.get("Note");
    }
  }
}
