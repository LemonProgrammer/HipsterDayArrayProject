package hipster.controller;

import javax.swing.JOptionPane;

import hipster.model.Hipster;
import hipster.view.HipsterFrame;

/**
 * Controller for the Hipster Project
 * 
 * @author fbla1201
 * @version 1.0 added constructor information.
 */

public class HipsterController
{
	private HipsterFrame appFrame;
	private Hipster selfieHipster;
	private Hipster[] classHipster;
	private int hipsterCount;
	
	/**
	 * @return the classHipster
	 */
	public Hipster[] getClassHipster()
	{
		return classHipster;
	}


	/**
	 * @param classHipster the classHipster to set
	 */
	public void setClassHipster(Hipster[] classHipster)
	{
		this.classHipster = classHipster;
	}

	

	/**
	 * Creates a HipsterController to be used as part of the MVC paradigm.
	 */
	public HipsterController()
	{
		
		selfieHipster = new Hipster();
		classHipster = new Hipster[3];
		hipsterCount = 0;
	}

	
	/**
	 * The first method that the Controller starts.
	 */
	public void start()
	{
		appFrame = new HipsterFrame(this);
	}

	/**
	 * @return the selfieHipster
	 */
	public Hipster getSelfieHipster()
	{
		return selfieHipster;
	}

	/**
	 * Replacing the current Hipster.
	 * 
	 * @param selfieHipster
	 *            The new Hipster to set.
	 */
	public void setSelfieHipster(Hipster selfieHipster)
	{
		this.selfieHipster = selfieHipster;
	}

	/**
	 * Used to retrieve a random Hipster object from the array of class Hipster.
	 * 
	 * @return
	 */
	public Hipster getRandomHipster()
	{
		Hipster currentHipster = null;
		int randomIndex = 0;
		double random = Math.random();
		randomIndex = (int) (random * classHipster.length);
		currentHipster = classHipster[randomIndex];

		return currentHipster;

	}

	/**
	 * Retrieves the Hipster from the specified position in the array.
	 * 
	 * @param position
	 *            The location in the array. It must be between 0 and
	 *            classHipster.length.
	 * @return The Hipster at the position in the array.
	 */
	public Hipster getSpecifiedHipster(int position)
	{
		Hipster currentHipster = null;

		if (position < classHipster.length && position >= 0)
		{
			currentHipster = classHipster[position];
		}

		return currentHipster;
	}

	/**
	 * creates and adds a hipster to the array of class Hipsters from the
	 * specified values.
	 * 
	 * @param books
	 * @param name
	 * @param type
	 * @param phrase
	 */
	public void addHipster(String[] books, String name, String type,
			String phrase)
	{
		if (hipsterCount < classHipster.length)
		{
			Hipster tempHipster = new Hipster(name, type, phrase, books);
			classHipster[hipsterCount] = tempHipster;
			hipsterCount++;
		} else
		{
			JOptionPane.showMessageDialog(appFrame,"The class is full you are to mainstream to be added");
		}
	}



}
