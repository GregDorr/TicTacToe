import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Greg
 *
 */
public class TicTacToe extends JFrame {

	// JPanels
	private JPanel[] buttonPanels;
	private JPanel gameBoard; 		// Layer for the other panels to rest on
	private JPanel bottomButton; 	// panel to hold the bottom two buttons
	private JPanel HUD;				//panel to hold the p1 and p2
	private JPanel p1; 				// for color coding the winner
	private JPanel p2; 				// for coding the playing turn

	// JButtons
	private JButton[] buttons;		//X and O buttons
	private JButton endButton;		//exit button

	// JLabels
	private JLabel message;			//displays the winner
	private JLabel turnLabel;		//displays whos turn it is

	// player number
	private int playerTurn;			//variable to keep track of who's turn it is

	// Threading
	private Thread thread2;			//background thread to check for the winner

	// constructor
	public TicTacToe() {
		// setting up the JFrame
		super("Tic Tac Toe");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());

		//initializing the panels and buttons
		initializePanelsButtons();
		
		playerTurn = 1;
		
		// for setting the HUD
		HUD = new JPanel(new GridLayout(1, 2));
		message = new JLabel("Winner: ");
		p1 = new JPanel();
		p1.add(message);
		HUD.add(p1);
		turnLabel = new JLabel("Turn: Player 1");
		p2 = new JPanel();
		p2.add(turnLabel);
		HUD.add(p2);

		// exit button
		endButton = new JButton("Exit");
		endButton.addActionListener(new EndingListener());
		bottomButton.add(endButton);
		// placing the bottom buttons in

		add(HUD, BorderLayout.NORTH);
		add(gameBoard, BorderLayout.CENTER);
		add(bottomButton, BorderLayout.SOUTH);

		// initializing and starting the background thread
		thread2 = new Thread(new WinThread());
		thread2.start();
	}

	//initializes panels and buttons
	private void initializePanelsButtons() {

		// initializing the panels
		buttonPanels = new JPanel[9];
		gameBoard = new JPanel(new GridLayout(3, 3));
		bottomButton = new JPanel(new FlowLayout());

		// initializing the buttons
		buttons = new JButton[9];

		// for declaring and initalizing all the buttons and jpanels
		for (int index = 0; index < 9; index++) {
			buttonPanels[index] = new JPanel(new GridBagLayout());
			buttons[index] = new JButton(" ");
			buttons[index].addActionListener(new buttonSetter(index));
			buttonPanels[index].add(buttons[index]);
			gameBoard.add(buttonPanels[index]);
		}

	}

	//background thread checks for a winner
	public void winChecker(String letter, int turn) {
		// 0,1,2
		if ((buttons[0].getText().equals(buttons[1].getText())) 
				&& (buttons[0].getText().equals(buttons[2].getText()))
				&& (buttons[0].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[0].setBackground(Color.BLUE);
						buttonPanels[1].setBackground(Color.BLUE);
						buttonPanels[2].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 0,4,8
		else if ((buttons[0].getText().equals(buttons[4].getText()))
				&& (buttons[0].getText().equals(buttons[8].getText())) 
				&& (buttons[0].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						message.setText("Winner: Player  " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[0].setBackground(Color.BLUE);
						buttonPanels[4].setBackground(Color.BLUE);
						buttonPanels[8].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 0,3,6
		else if ((buttons[0].getText().equals(buttons[3].getText()))
				&& (buttons[0].getText().equals(buttons[6].getText())) 
				&& (buttons[0].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[0].setBackground(Color.BLUE);
						buttonPanels[3].setBackground(Color.BLUE);
						buttonPanels[6].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 3,4,5
		else if ((buttons[3].getText().equals(buttons[4].getText()))
				&& (buttons[3].getText().equals(buttons[5].getText())) 
				&& (buttons[3].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[3].setBackground(Color.BLUE);
						buttonPanels[4].setBackground(Color.BLUE);
						buttonPanels[5].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}

		}

		// 6,7,8
		else if ((buttons[6].getText().equals(buttons[7].getText()))
				&& (buttons[6].getText().equals(buttons[8].getText())) 
				&& (buttons[6].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {

						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[6].setBackground(Color.BLUE);
						buttonPanels[7].setBackground(Color.BLUE);
						buttonPanels[8].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 1,4,7
		else if ((buttons[1].getText().equals(buttons[4].getText()))
				&& (buttons[1].getText().equals(buttons[7].getText())) 
				&& (buttons[1].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {

						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[1].setBackground(Color.BLUE);
						buttonPanels[4].setBackground(Color.BLUE);
						buttonPanels[7].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 2,5,8
		else if ((buttons[2].getText().equals(buttons[5].getText()))
				&& (buttons[2].getText().equals(buttons[8].getText())) 
				&& (buttons[2].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[2].setBackground(Color.BLUE);
						buttonPanels[5].setBackground(Color.BLUE);
						buttonPanels[8].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 2,4,6
		else if ((buttons[6].getText().equals(buttons[4].getText()))
				&& (buttons[6].getText().equals(buttons[2].getText())) 
				&& (buttons[6].getText().equals(letter))) {
			
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						message.setText("Winner: Player " + turn);
						p1.setBackground(Color.GREEN);
						buttonPanels[6].setBackground(Color.BLUE);
						buttonPanels[4].setBackground(Color.BLUE);
						buttonPanels[2].setBackground(Color.BLUE);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tie()
	{
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					message.setText("Winner: TIE ");
					p1.setBackground(Color.RED);
					for(int index = 0; index < 9; index++){
						buttonPanels[index].setBackground(Color.RED);
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	// class to end the program
	class EndingListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	// class to set the button to an x or o
	class buttonSetter implements ActionListener {

		private int number;

		public buttonSetter(int num) {
			number = num;
		}

		public void actionPerformed(ActionEvent e) {
			if (playerTurn == 1) {
				// update the win checker thread
				synchronized (buttons) {
					// set the button to have an X on it
					buttons[number].setText("X");
					buttons[number].updateUI();
					buttons.notifyAll();
				}

				// switch turn
				playerTurn = 2;
				turnLabel.setText("Turn: Player 2");
				turnLabel.updateUI();
			}

			else if (playerTurn == 2) {
				// update the win checker thread
				synchronized (buttons) {
					// set the button to have an O
					buttons[number].setText("O");
					buttons[number].updateUI();
					buttons.notifyAll();
				}

				// switch turn
				playerTurn = 1;
				turnLabel.setText("Turn: Player 1");
				turnLabel.updateUI();
			}
		}
	}
	//thread winChecker
	class WinThread implements Runnable {

		private int turn;
		private int count;

		public WinThread() {
			turn = 1;
		}

		public void run() {
			while (true) {
				synchronized (buttons) {
					try {
						buttons.wait();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (turn == 1) {
						winChecker("X", turn);
						turn = 2;
					}

					else {
						winChecker("O", turn);
						turn = 1;
					}
				}

				count++;
				if (count == 9) {
					tie();
				}
			}
		}

	}

	public static void main(String[] args) {
		TicTacToe test = new TicTacToe();
		test.setVisible(true);
	}
}
