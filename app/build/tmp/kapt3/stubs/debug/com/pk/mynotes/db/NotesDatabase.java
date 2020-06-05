package com.pk.mynotes.db;

import java.lang.System;

@androidx.room.Database(entities = {com.pk.mynotes.models.Note.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/pk/mynotes/db/NotesDatabase;", "Landroidx/room/RoomDatabase;", "()V", "notesDao", "Lcom/pk/mynotes/interfaces/NotesDao;", "Companion", "app_debug"})
public abstract class NotesDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable()
    private static volatile com.pk.mynotes.db.NotesDatabase instance;
    private static final java.lang.Object LOCK = null;
    public static final com.pk.mynotes.db.NotesDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pk.mynotes.interfaces.NotesDao notesDao();
    
    public NotesDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/pk/mynotes/db/NotesDatabase$Companion;", "", "()V", "LOCK", "instance", "Lcom/pk/mynotes/db/NotesDatabase;", "getInstance", "()Lcom/pk/mynotes/db/NotesDatabase;", "setInstance", "(Lcom/pk/mynotes/db/NotesDatabase;)V", "buildDb", "context", "Landroid/content/Context;", "invoke", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.pk.mynotes.db.NotesDatabase getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable()
        com.pk.mynotes.db.NotesDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.pk.mynotes.db.NotesDatabase invoke(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.pk.mynotes.db.NotesDatabase buildDb(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}