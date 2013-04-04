package net.sf.anathema.character.reporting.pdf.content.abilities;

import net.sf.anathema.character.generic.character.IGenericCharacter;
import net.sf.anathema.character.generic.character.IGenericTraitCollection;
import net.sf.anathema.character.generic.template.magic.AbilityFavoringType;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.groups.IIdentifiedTraitTypeGroup;
import net.sf.anathema.character.generic.traits.types.AbilityType;
import net.sf.anathema.character.reporting.pdf.content.traits.FavorableTraitContent;
import net.sf.anathema.lib.resources.Resources;

import java.util.Arrays;
import java.util.List;

public class AbilitiesContent extends FavorableTraitContent {

  public AbilitiesContent(IGenericCharacter character, Resources resources) {
    super(character, resources);
  }

  @Override
  public List<? extends ITraitType> getMarkedTraitTypes() {
    return Arrays.asList(AbilityType.Athletics, AbilityType.Dodge, AbilityType.Larceny, AbilityType.Ride, AbilityType.Stealth);
  }

  @Override
  public boolean shouldShowExcellencies() {
    return getCharacter().getTemplate().getTemplateType().getCharacterType().getFavoringTraitType().equals(new AbilityFavoringType());
  }

  @Override
  public IIdentifiedTraitTypeGroup[] getIdentifiedTraitTypeGroups() {
    return getCharacter().getAbilityTypeGroups();
  }

  @Override
  public IGenericTraitCollection getTraitCollection() {
    return getCharacter().getTraitCollection();
  }

  @Override
  public String getGroupNamePrefix() {
    return "AbilityGroup.";
  }

  @Override
  public String getTraitTypePrefix() {
    return "";
  }

  @Override
  public String getMarkerCommentKey() {
    return "Sheet.Comment.AbilityMobility";
  }

  @Override
  public String getExcellencyCommentKey() {
    return "Sheet.Comment.AbilityExcellency";
  }

  @Override
  public String getHeaderKey() {
    return "Abilities";
  }
}
