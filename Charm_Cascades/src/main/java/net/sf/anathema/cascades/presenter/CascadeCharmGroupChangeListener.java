package net.sf.anathema.cascades.presenter;

import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.framework.ui.RGBColor;
import net.sf.anathema.hero.charms.display.presenter.AbstractCharmGroupChangeListener;
import net.sf.anathema.hero.charms.display.presenter.CharmDisplayPropertiesMap;
import net.sf.anathema.hero.charms.display.view.CharmView;
import net.sf.anathema.lib.util.Identifier;
import net.sf.anathema.platform.tree.document.visualizer.TreePresentationProperties;

public class CascadeCharmGroupChangeListener extends AbstractCharmGroupChangeListener {

  private final CharmView cascadeView;
  private final CascadeSpecialCharmSet specialCharmSet;

  public CascadeCharmGroupChangeListener(CharmView cascadeView, CascadeSpecialCharmSet specialCharmSet,
                                         CharmDisplayPropertiesMap charmDisplayPropertiesMap) {
    super(new FriendlyCharmGroupArbitrator(), cascadeView.getCharmTreeRenderer(), charmDisplayPropertiesMap);
    this.cascadeView = cascadeView;
    this.specialCharmSet = specialCharmSet;
  }

  @Override
  protected final void modifyCharmVisuals(Identifier type) {
    specialCharmSet.setType(type);
    RGBColor color = findColor(type);
    cascadeView.setBackgroundColor(color);
  }

  private RGBColor findColor(Identifier type) {
    if (type instanceof CharacterType) {
      TreePresentationProperties displayProperties = getDisplayProperties((CharacterType) type);
      return displayProperties.getColor();
    } else {
      return RGBColor.White;
    }
  }
}