package net.sf.anathema.character.model.charm;

import net.sf.anathema.character.generic.framework.additionaltemplate.model.TraitContext;
import net.sf.anathema.character.generic.health.HealthLevelType;
import net.sf.anathema.character.generic.impl.traits.SimpleTraitTemplate;
import net.sf.anathema.character.library.trait.DefaultTraitType;
import net.sf.anathema.character.library.trait.LimitedTrait;
import net.sf.anathema.character.library.trait.favorable.IncrementChecker;

public class OxBodyCategory extends LimitedTrait {

  private final String id;
  private final HealthLevelType[] healthLevelTypes;

  public OxBodyCategory(TraitContext context, HealthLevelType[] healthLevelTypes, String id, IncrementChecker incrementChecker) {
    super(new DefaultTraitType("OxBodyTechnique"),
            SimpleTraitTemplate.createEssenceLimitedTemplate(0), incrementChecker, context);
    this.healthLevelTypes = healthLevelTypes;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public int getHealthLevelTypeCount(HealthLevelType type) {
    int count = 0;
    for (HealthLevelType categoryType : healthLevelTypes) {
      if (categoryType == type) {
        count++;
      }
    }
    return count;
  }
}