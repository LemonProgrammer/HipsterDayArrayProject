package hipster.view;

import hipster.controller.HipsterController;

import javax.swing.JFrame;

/**
 * creates a JFrame for the project.
 * @author fbla1201
 *@version 1.0
 */
public class HipsterFrame extends JFrame
{
	private HipsterController baseController;
	private HipsterPanel basePanel;
	
	/**
	 * Setting out the HipsterFrame and building it.
	 * @param baseController
	 */
	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		
		setupFrame();
		
	}
/**
 * Helper  method that sets up the Frame for the HIpsterFrame.
 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(450, 500);
		this.setVisible(true);
		
	}
}
