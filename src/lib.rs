pub mod recursion {
    fn min_recursively(arr: &[i32], n: usize) -> i32 {
        if n == 1 {
            return arr[0];
        }

        let current_min = min_recursively(arr, n - 1);

        if current_min < arr[n - 1] {
            return current_min;
        }

        return arr[n - 1];
    }

    pub fn min(arr: &[i32]) -> i32 {
        return min_recursively(arr, arr.len());
    }

    fn average_recursively(arr: &[i32], n: usize) -> f64 {
        if n == 1 {
            return arr[0] as f64;
        }
        return (average_recursively(arr, n - 1) * (n - 1) as f64 + arr[n - 1] as f64) / n as f64;
    }

    pub fn average(arr: &[i32]) -> f64 {
        return average_recursively(arr, arr.len());
    }

    fn is_prime_recursively(n: u64, i: u64) -> bool {
        if i == 1 {
            return true;
        }
        if n % i == 0 {
            return false;
        }
        return is_prime_recursively(n, i - 1);
    }

    pub fn is_prime(n: u64) -> bool {
        match n {
            0 => return false,
            1 => return false,
            _ => return is_prime_recursively(n, n / 2),
        }
    }

    pub fn factorial(n: u64) -> u64 {
        match n {
            0 => 1,
            _ => n * factorial(n - 1),
        }
    }

    fn fibonacci_recursive(n: u64) -> u64 {
        match n {
            0 => 0,
            1 => 1,
            _ => fibonacci(n - 1) + fibonacci(n - 2),
        }
    }

    pub fn fibonacci(n: u64) -> u64 {
        return fibonacci_recursive(n);
    }

    pub fn power(a: u64, n: u64) -> u64 {
        match n {
            0 => 1,
            _ => a * power(a, n - 1),
        }
    }

    pub fn is_digit(c: char) -> bool {
        c >= '0' && c <= '9'
    }

    fn is_digits_recursively(s: &str) -> bool {
        if s.is_empty() {
            return true;
        }
        if is_digit(s.chars().next().unwrap()) {
            return is_digits_recursively(&s[1..]);
        }
        return false;
    }

    pub fn is_digits(s: &str) -> bool {
        if s.is_empty() {
            return false;
        }
        return is_digits_recursively(s);
    }

    fn backtrack(chars: &mut [char], start: usize, result: &mut Vec<String>) {
        if start == chars.len() {
            result.push(chars.iter().collect());
            return;
        }
        for i in start..chars.len() {
            chars.swap(start, i);
            backtrack(chars, start + 1, result);
            chars.swap(start, i);
        }
    }

    pub fn permute(s: &str) -> Vec<String> {
        let mut result = Vec::new();
        let mut chars: Vec<char> = s.chars().collect();

        backtrack(&mut chars, 0, &mut result);

        return result;
    }

    pub fn binomial_coefficient(n: u64, k: u64) -> u64 {
        match k {
            0 => 1,
            _ if k == n => 1,
            _ => binomial_coefficient(n - 1, k - 1) + binomial_coefficient(n - 1, k),
        }
    }

    pub fn gcd(a: u64, b: u64) -> u64 {
        match b {
            0 => a,
            _ => gcd(b, a % b),
        }
    }
}

pub mod algorithms {
    fn binary_search(arr: &[i32], x: i32) -> Option<usize> {
        let mut left = 0;
        let mut right = arr.len() - 1;

        while left <= right {
            let mid = (left + right) / 2;

            if arr[mid] == x {
                return Some(mid);
            }

            if arr[mid] < x {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return None;
    }

    pub fn search(arr: &[i32], x: i32) -> Option<usize> {
        return binary_search(arr, x);
    }

    fn bubble_sort(arr: &mut [i32]) {
        let mut swapped = true;
        while swapped {
            swapped = false;
            for i in 1..arr.len() {
                if arr[i - 1] > arr[i] {
                    arr.swap(i - 1, i);
                    swapped = true;
                }
            }
        }
    }

    pub fn sort(arr: &mut [i32]) {
        bubble_sort(arr);
    }
}
