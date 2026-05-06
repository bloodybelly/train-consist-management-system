// ===============================
// 🚀 UC16: BUBBLE SORT (NO LIBRARY)
// ===============================

System.out.println("\n--- UC16: Bubble Sort on Capacities ---");

// Step 1: Create array of capacities
int[] capacities = {72, 50, 100, 60, 40};

// Display before sorting
System.out.println("Before Sorting:");
for (int c : capacities) {
        System.out.print(c + " ");
}

// Step 2: Bubble Sort
int n = capacities.length;

for (int i = 0; i < n - 1; i++) {

        for (int j = 0; j < n - i - 1; j++) {

        // Compare adjacent elements
        if (capacities[j] > capacities[j + 1]) {

// Swap
int temp = capacities[j];
capacities[j] = capacities[j + 1];
capacities[j + 1] = temp;
        }
                }
                }

// Step 3: Display sorted array
                System.out.println("\nAfter Sorting:");
for (int c : capacities) {
        System.out.print(c + " ");
}
        System.out.println();// ===============================
// 🚀 UC16: BUBBLE SORT (NO LIBRARY)
// ===============================

System.out.println("\n--- UC16: Bubble Sort on Capacities ---");

// Step 1: Create array of capacities
int[] capacities = {72, 50, 100, 60, 40};

// Display before sorting
System.out.println("Before Sorting:");
for (int c : capacities) {
        System.out.print(c + " ");
}

// Step 2: Bubble Sort
int n = capacities.length;

for (int i = 0; i < n - 1; i++) {

        for (int j = 0; j < n - i - 1; j++) {

        // Compare adjacent elements
        if (capacities[j] > capacities[j + 1]) {

// Swap
int temp = capacities[j];
capacities[j] = capacities[j + 1];
capacities[j + 1] = temp;
        }
                }
                }

// Step 3: Display sorted array
                System.out.println("\nAfter Sorting:");
for (int c : capacities) {
        System.out.print(c + " ");
}
        System.out.println();