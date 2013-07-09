package net.sf.anathema.character.equipment.reporting.content.stats.armour;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import net.sf.anathema.character.main.equipment.weapon.IArmourStats;

public interface IArmourStatsGroup {

  void addTotal(PdfPTable table, Font font, IArmourStats armour);
}