package net.sf.anathema.character.reporting.pdf.content.stats.magic;

import com.google.common.base.Function;
import net.sf.anathema.character.generic.framework.magic.stringbuilder.IMagicSourceStringBuilder;
import net.sf.anathema.character.generic.framework.magic.stringbuilder.source.MagicSourceStringBuilder;
import net.sf.anathema.character.generic.magic.IMagicStats;
import net.sf.anathema.character.generic.magic.ISpell;
import net.sf.anathema.lib.resources.Resources;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static net.sf.anathema.lib.lang.ArrayUtilities.transform;

public class SpellStats extends AbstractMagicStats<ISpell> {

  public SpellStats(ISpell spell) {
    super(spell);
  }

  @Override
  public String getGroupName(Resources resources) {
    return resources.getString("Sheet.Magic.Group.Sorcery");
  }

  @Override
  public String getType(Resources resources) {
    return resources.getString(getMagic().getCircleType().getId());
  }

  @Override
  public String getDurationString(Resources resources) {
    return "-";
  }

  @Override
  public String getSourceString(Resources resources) {
    IMagicSourceStringBuilder<ISpell> stringBuilder = new MagicSourceStringBuilder<>(resources);
    return stringBuilder.createShortSourceString(getMagic());
  }

  protected String[] getDetailKeys() {
    String target = getMagic().getTarget();
    if (target != null) {
      return new String[]{"Spells.Target." + target};
    }
    return new String[0];
  }

  @Override
  public String[] getDetailStrings(final Resources resources) {
    return transform(getDetailKeys(), String.class, new Function<String, String>() {
      @Override
      public String apply(String input) {
        return resources.getString(input);
      }
    });
  }

  @Override
  public String getNameString(Resources resources) {
    return resources.getString(getMagic().getId());
  }

  @Override
  public int compareTo(IMagicStats stats) {
    if (stats instanceof AbstractCharmStats) {
      return 1;
    }
    SpellStats spell = (SpellStats) stats;
    int r = getMagic().getCircleType().compareTo(spell.getMagic().getCircleType());
    if (r == 0) {
      r = getMagic().getId().compareTo(spell.getMagic().getId());
    }
    return r;
  }

  @SuppressWarnings("SimplifiableIfStatement")
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }
    return compareTo((SpellStats) obj) == 0;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(getMagic().getCircleType()).append(getMagic().getId()).build();
  }
}
