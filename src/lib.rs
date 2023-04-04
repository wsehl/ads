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

    pub fn fibonacci(n: u64) -> u64 {
        match n {
            0 => 0,
            1 => 1,
            _ => fibonacci(n - 1) + fibonacci(n - 2),
        }
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
