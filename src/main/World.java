package main;

import java.util.Random;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2017年3月24日
 * 
 * The World class, in form of a 2-dimensional worldrix denoting distribution and life status of lives
 * 
 */

public class World
{
	public static void main(String[] args)
	{
		World world=new World(50);
		world.start();
	}
	
	private int[][] world;
	public World(int size){
		world=new int[size][size];
		Random rand=new Random();
		for(int i=0;i<world.length;i++){
			for(int j=0;j<world[i].length;j++){
				world[i][j]=rand.nextInt(2);
			}
		}
	}
	
	public void start(){
		Window.outputMatrix(world);
		Window window=new Window(world, new Rule());
		for(int i=0;i<=50;i++){
			new Thread(window).start();
		}
		
	}
	
}

