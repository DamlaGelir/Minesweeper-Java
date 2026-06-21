# 💣 Custom Aesthetic Minesweeper

A modern, desktop-based Minesweeper implementation developed completely from scratch using Java Swing and Java AWT. This project emphasizes core Object-Oriented Programming (OOP) concepts, robust state management, real-time background threads, and custom visual design.

---

## 🚀 Overview

This application provides a standard 10x10 Minesweeper matrix containing 10 hidden mines. It moves away from standard operating system UI styles to implement a custom, modern color theme. The project is designed with modularity in mind, cleanly separating game logic, board generation, and real-time clock synchronization.

---

## ✨ Comprehensive Features

- **Dynamic Grid & Safe Random Generation:** Utilizes a nested 2D array (int[10][10]) where 1 represents a mine and 0 is a safe cell. A while loop guarantees exactly 10 unique mine coordinates are generated with duplicate prevention.
- **Smart Move Validation:** Implements a state-check at the beginning of actions. If a button's text is already modified, the event listener intercepts and halts execution, preventing players from re-clicking opened cells.
- **Real-Time Thread-Safe Clock:** Runs an active background worker via javax.swing.Timer executing on a 1000ms delay. It dynamically updates the GUI without blocking the main event thread.
- **Referential Integrity Reset System:** The restartGame() method completely flushes old memory pointers, wipes data matrices, stops ongoing timers, resets the UI background components back to their original configuration, and redeploys the game loop smoothly.
- **Advanced Win/Loss Evaluation:** * Loss Condition: Instantly halts the clock, colors the triggered cell vibrant Red, displays a custom native dialogue box, and prevents downstream logic execution.
  * Win Condition: Dynamically scans the button grid on every valid click. Once exactly 90 safe buttons are verified as successfully opened, it automatically halts the clock and displays a triumph message showing your exact survival time.

---

## 🛠️ Code Architecture & Core Methods

The codebase is engineered to be highly modular and easy to read:

1. **Minesweeper() (Constructor):** Initializes the main operating window (JFrame), configures dimensions, and combines BorderLayout and GridLayout(1, 2) inside a dedicated topPanel to place the navigation buttons and the scoreboard side-by-side.
2. **generateMines():** Leverages pseudo-random double generation (Math.random()) scaled to index sizes [0-9] to safely plant exactly 10 distinct mines.
3. **checkMine(int r, int c):** The core engine of the game loop. Uses localized dual-loop indexing from -1 to 1 to count adjacent mines, validating edge boundaries securely.
4. **restartGame():** Handles memory cleanup, hard-stops the timer thread, resets integer tracking values back to zero, and refreshes the panel states.

---

## 💻 Step-by-Step Installation & Usage Guide

Follow these steps to clone, configure, and execute this project on your local operating system.

### Prerequisites
Make sure you have Java Development Kit (JDK) Version 11 or higher installed on your machine.

### Step 1: Clone the Repository
Open your operating system's terminal (Command Prompt, PowerShell, or Git Bash) and execute the clone command (replace YOUR_USERNAME with your actual GitHub username):
git clone [https://github.com/YOUR_USERNAME/Minesweeper-Java.git](https://github.com/YOUR_USERNAME/Minesweeper-Java.git)

After cloning, navigate directly into the project root directory using this command:
cd Minesweeper-Java

### Step 2: Organize Asset Path
To ensure the custom bomb icon renders perfectly across different operating systems, use a relative path:
1. Take your bomb.png file and place it directly inside the exact same directory folder where Minesweeper.java is located.
2. Open Minesweeper.java in your editor, locate the ImageIcon instantiation line (around line 28), and update the code line to point dynamically to the local root like this: icon = new ImageIcon("bomb.png");

### Step 3: Compile the Source Code
Using your terminal, compile the Java source file into executable bytecode using the compiler tool command:
javac Minesweeper.java

### Step 4: Launch the Application
Execute the compiled bytecode using the Java Runtime Environment launcher command:
java Minesweeper

---

## 🎨 Aesthetic Specifications

- Default Unrevealed Grid: Deep Forest Green -> new Color(0, 100, 0)
- Successfully Cleared Safe Grid: Light Pastel Mint -> new Color(152, 251, 152)
- Triggered Mine Indicator: Warning Crimson Red -> Color.RED
- Typography Engine: High-contrast Color.BLACK with bold Arial typeface scaling.
