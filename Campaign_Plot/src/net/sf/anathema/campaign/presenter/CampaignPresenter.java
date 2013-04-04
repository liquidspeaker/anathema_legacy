package net.sf.anathema.campaign.presenter;

import net.sf.anathema.campaign.model.ISeries;
import net.sf.anathema.campaign.presenter.plot.PlotPresenter;
import net.sf.anathema.campaign.presenter.view.ISeriesView;
import net.sf.anathema.lib.gui.Presenter;
import net.sf.anathema.lib.resources.Resources;

public class CampaignPresenter implements Presenter {

  private final ISeriesView campaignView;
  private final ISeries campaign;
  private final Resources resources;

  public CampaignPresenter(ISeriesView campaignView, Resources resources, ISeries campaign) {
    this.campaignView = campaignView;
    this.resources = resources;
    this.campaign = campaign;
  }

  @Override
  public void initPresentation() {
    new PlotPresenter(
        resources,
        campaignView.addPlotView(resources.getString("CampaignDescription.BorderTitle")), campaign.getPlot()).initPresentation();
  }
}