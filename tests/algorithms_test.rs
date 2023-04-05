use ads::algorithms::*;

#[test]
fn search_works() {
    assert_eq!(search(&[0, 1, 2, 3, 4], 1), Some(1));
    assert_eq!(search(&[0, 1, 2, 3, 4], 10), None);
}

#[test]
fn sort_works() {
    let mut arr = [4, 3, 2, 1];
    sort(&mut arr);
    assert_eq!(arr, [1, 2, 3, 4]);
}
