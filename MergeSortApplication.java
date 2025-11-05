
class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class MergeSortApplication {

    // Merge Sort function
    public static void mergeSort(Employee[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted halves
    public static void merge(Employee[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Employee[] leftArr = new Employee[n1];
        Employee[] rightArr = new Employee[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];

        for (int i = 0; i < n2; i++)
            rightArr[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        // Merge in sorted order based on salary
        while (i < n1 && j < n2) {
            if (leftArr[i].salary <= rightArr[j].salary) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1)
            arr[k++] = leftArr[i++];

        while (j < n2)
            arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Ayush", 45000),
            new Employee("Riya", 30000),
            new Employee("Sam", 45000), // Same salary to show stable sorting
            new Employee("Neha", 60000),
            new Employee("Amit", 35000)
        };

        System.out.println("Before Sorting:");
        for (Employee e : employees)
            System.out.println(e.name + " - " + e.salary);

        mergeSort(employees, 0, employees.length - 1);

        System.out.println("\nAfter Sorting by Salary:");
        for (Employee e : employees)
            System.out.println(e.name + " - " + e.salary);
    }
}
