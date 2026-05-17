package kr.ac.classroom.reservation.server.storage;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileStorage {
    private final Path dataDirectory;

    public FileStorage(Path dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public void ensureDataDirectory() {
        try {
            Files.createDirectories(dataDirectory);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    public Path resolve(String fileName) {
        return dataDirectory.resolve(fileName);
    }
}
