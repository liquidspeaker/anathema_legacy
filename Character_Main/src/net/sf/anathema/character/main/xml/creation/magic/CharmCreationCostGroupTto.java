package net.sf.anathema.character.main.xml.creation.magic;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.Map;

public class CharmCreationCostGroupTto implements Serializable {

  public int charmCost = 0;
  public int highLevelMartialArtsCharmCost = 0;
  public Map<String, Integer> keywordCosts;


  @Override
  public CharmCreationCostGroupTto clone() {
    return SerializationUtils.clone(this);
  }
}