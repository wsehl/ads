use ads::recursion::*;

#[test]
fn problem_1() {
    assert_eq!(min(&[1]), 1);
    assert_eq!(min(&[10, 1, 32, 3, 45]), 1);
    assert_eq!(min(&[1, 4, 8, 10]), 1);
}

#[test]
fn problem_2() {
    assert_eq!(average(&[1]), 1.0);
    assert_eq!(average(&[1, 2, 3]), 2.0);
    assert_eq!(average(&[3, 2, 4, 1]), 2.5);
}

#[test]
fn problem_3() {
    assert_eq!(is_prime(0), false);
    assert_eq!(is_prime(1), false);
    assert_eq!(is_prime(2), true);
    assert_eq!(is_prime(3), true);
    assert_eq!(is_prime(4), false);
    assert_eq!(is_prime(5), true);
    assert_eq!(is_prime(6), false);
    assert_eq!(is_prime(7), true);
}

#[test]
fn problem_4() {
    assert_eq!(factorial(0), 1);
    assert_eq!(factorial(1), 1);
    assert_eq!(factorial(2), 2);
    assert_eq!(factorial(3), 6);
    assert_eq!(factorial(4), 24);
    assert_eq!(factorial(5), 120);
}

#[test]
fn problem_5() {
    assert_eq!(fibonacci(0), 0);
    assert_eq!(fibonacci(1), 1);
    assert_eq!(fibonacci(2), 1);
    assert_eq!(fibonacci(6), 8);
}

#[test]
fn problem_6() {
    assert_eq!(power(2, 0), 1);
    assert_eq!(power(2, 1), 2);
    assert_eq!(power(2, 2), 4);
    assert_eq!(power(3, 3), 27);
    assert_eq!(power(2, 10), 1024);
}

#[test]
fn problem_8() {
    assert_eq!(is_digit('\n'), false);
    assert_eq!(is_digit('0'), true);
    assert_eq!(is_digits("123"), true);
    assert_eq!(is_digits("123a12"), false);
    assert_eq!(is_digits(""), false);
}

#[test]
fn problem_9() {
    assert_eq!(binomial_coefficient(2, 1), 2);
    assert_eq!(binomial_coefficient(7, 3), 35);
    assert_eq!(binomial_coefficient(5, 4), 5);
    assert_eq!(binomial_coefficient(5, 5), 1);
}

#[test]
fn problem_10() {
    assert_eq!(gcd(0, 0), 0);
    assert_eq!(gcd(32, 48), 16);
    assert_eq!(gcd(10, 7), 1);
}
