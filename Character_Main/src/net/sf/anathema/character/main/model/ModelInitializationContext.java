package net.sf.anathema.character.main.model;

import net.sf.anathema.character.change.ChangeAnnouncer;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.TraitContext;
import net.sf.anathema.character.generic.template.HeroTemplate;
import net.sf.anathema.character.impl.model.context.CharacterListening;
import net.sf.anathema.character.main.model.change.ChangeAnnouncerAdapter;

public class ModelInitializationContext implements InitializationContext {

  private ICharacterModelContext context;
  private Hero hero;
  private HeroTemplate template;

  public ModelInitializationContext(ICharacterModelContext context, Hero hero, HeroTemplate template) {
    this.context = context;
    this.hero = hero;
    this.template = template;
  }

  @Override
  public HeroTemplate getTemplate() {
    return template;
  }

  @Override
  public TraitContext getTraitContext() {
    return context.getTraitContext();
  }

  @Override
  public ChangeAnnouncer getChangeAnnouncer() {
    CharacterListening listening = (CharacterListening) context.getCharacterListening();
    return new ChangeAnnouncerAdapter(listening, hero);
  }
}
