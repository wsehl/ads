pub mod recursion {
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
