package main

func repeatedNTimes(nums []int) int {
	n := len(nums) / 2
	freq := make(map[int]int)
	for _, num := range nums {
		freq[num]++
		if freq[num] == n {
			return num
		}
	}
	return -1
}
