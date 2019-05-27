package p3;

import java.util.ArrayList;

public interface OVChipKaartProductDao<OVChipKaarProduct> {
	public OVChipKaarProduct findById(int id);
	public ArrayList<OVChipKaarProduct> findByIdInBothTables(int id);
}