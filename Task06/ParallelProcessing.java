import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


 /**
 * The class Parallel processing extends J frame implements action listener
 */ 
public class ParallelProcessing extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JButton startButton;
    private JTextArea outputArea;
    

/** 
 *
 * Parallel processing
 *
 * @return public
 */
    public ParallelProcessing() { 

        setTitle("Parallel Processing Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    @Override

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
    public void actionPerformed(ActionEvent e) { 

        if (e.getSource() == startButton) {
            startParallelProcessing();
        }
    }
    

/** 
 *
 * Start parallel processing
 *
 */
    private void startParallelProcessing() { 

        // Створюємо колекцію з випадковими числами
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(100));
        }

        // Створюємо чергу команд
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        
        // Додаємо команди в чергу
        queue.add(() -> output("Min value: " + Collections.min(numbers)));
        queue.add(() -> output("Max value: " + Collections.max(numbers)));
        queue.add(() -> output("Avg value: " + numbers.stream().mapToInt(Integer::intValue).average().getAsDouble()));
        queue.add(() -> {
            List<Integer> filtered = new ArrayList<>();
            for (int num : numbers) {
                if (num % 2 == 0) {
                    filtered.add(num);
                }
            }
            output("Filtered: " + filtered);
        });

        // Створюємо п'ять робочих потоків
        for (int i = 0; i < 5; i++) {
            new WorkerThread(queue).start();
        }
    }
    

/** 
 *
 * Output
 *
 * @param message  the message. 
 */
    private void output(String message) { 

        SwingUtilities.invokeLater(() -> outputArea.append(message + "\n"));
    }
    

/** 
 *
 * Main
 *
 * @param args  the args. 
 */
    public static void main(String[] args) { 

        SwingUtilities.invokeLater(() -> new ParallelProcessing().setVisible(true));
    }
}
