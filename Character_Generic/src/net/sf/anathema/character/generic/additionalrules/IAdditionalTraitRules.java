package net.sf.anathema.character.generic.additionalrules;

import net.sf.anathema.character.generic.character.ILimitationContext;
import net.sf.anathema.character.generic.traits.IGenericTrait;

public interface IAdditionalTraitRules {

  public boolean isAllowedTraitValue(IGenericTrait trait, ILimitationContext limitationContext);
}