package net.sf.anathema.initialization.repository;

import java.nio.file.Path;

public interface DataFileProvider {

  Path getDataBaseDirectory(String subfolderName);
}