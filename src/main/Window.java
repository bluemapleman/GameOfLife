package main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2017年3月24日
 */
public class Window implements Runnable
{
	private JFrame frame;
	private JPanel[][] panels;
	private int status[][];
	private Rule rule;
	
	
//	public Window(){};
	public Window(int[][] mat,Rule rule){
		this.status=mat;
		this.rule=rule;
	}
	
	public synchronized void showWindow(int[][] mat,Rule rule){
		int size=mat.length;
		status=mat;
		frame=new JFrame("Legion");
		frame.setBounds(500, 500, 800, 800);
		frame.setLayout(new GridLayout(size,size));
		panels=new JPanel[size][size];
		for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
            	panels[i][j]=new JPanel();
                frame.add(panels[i][j]);
            }
	     }		
		frame.setVisible(true);
		cycle(rule);
	}
	
	/**
	 * Start the world, let the evolution begin!!!
	 * @param frame
	 */
	public synchronized void cycle(Rule rule){
		int liveNum=rule.getliveNum();
		int stayNum=rule.getStayNum();
		int size=panels.length;
		while(true){
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					int count=0;
					if(i==0){
						if(j==0){
							for(int x=i;x<2;x++){
								for(int y=0;y<2;y++){
									if(x==0 & y==0)
										continue;
									if(status[x][y]==1)
										count++;
								}
							}
						}
						else if(j==size-1){
							for(int x=0;x<2;x++){
								for(int y=size-2;y<size;y++){
									if(x==0 & y==size-1)
										continue;
									if(status[x][y]==1)
										count++;
								}
							}
						}
						else{
							for(int x=i;x<2;x++){
								for(int y=j-1;y<j+2;y++){
									if(x==0 & y==j)
										continue;
									if(status[x][y]==1)
										count++;
								}
							}
						}
					}
					else if(i==size-1){
						if(j==0){
							for(int x=size-2;x<size;x++){
								for(int y=0;y<2;y++){
									if(x==size-1 & y==0)
										continue;
									if(status[x][y]==1)
										count++;
								}
							}
						}
						else if(j==size-1){
							for(int x=size-2;x<size;x++){
								for(int y=size-2;y<size;y++){
									if(x==size-1 & y==size-1)
										continue;
									if(status[x][y]==1)
										count++;
								}
							}
						}
						else{
							for(int x=size-2;x<size;x++){
								for(int y=j-1;y<j+2;y++){
									if(x==size-1 & y==j)
										continue;
									if(status[x][y]==1)
										count++;
								}
							}
						}
					}
					else if(j==0 & i!=0 & i!=size-1){
						for(int x=i-1;x<i+2;x++){
							for(int y=j;y<j+2;y++){
								if(x==i & y==j)
									continue;
								if(status[x][y]==1)
									count++;
							}
						}
					}
					else if(j==size-1 & i!=0 & i!=size-1){
						for(int x=i-1;x<i+2;x++){
							for(int y=j-2;y<j;y++){
								if(x==i & y==j)
									continue;
								if(status[x][y]==1)
									count++;
							}
						}
					}
					else{
						for(int x=i-1;x<i+2;x++){
							for(int y=j-1;y<j+2;y++){
								if(x==i & y==j)
									continue;
								if(status[x][y]==1)
									count++;
							}
						}
					}
					if(count==liveNum)
						status[i][j]=1;
					else if(count==stayNum){;}
					else
						status[i][j]=0;
				}
			}
			refresh();
		}
	}
	
	public void refresh(){
		int size=panels.length;
		for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(status[i][j]==1)
                	panels[i][j].setBackground(Color.black);
                else
                	panels[i][j].setBackground(Color.white);
            }
	     }		
	}
	
	public static void outputMatrix(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}
	}

	@Override
	public void run()
	{
		showWindow(status, rule);
	}
	
	
	
	
	
	
}

