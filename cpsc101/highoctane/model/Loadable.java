package cpsc101.highoctane.model;

import java.io.File;

public interface Loadable
{
	boolean canLoad(File file);
	void loadFromFile(File file);
}
