package main

import (
	"fmt"
	"sync"
)

func sayAny(text string, wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Println(text)
}

func main() {
	var wg sync.WaitGroup
	frase := "Hola mundo"

	wg.Add(1)
	go sayAny(frase, &wg)
	wg.Wait()

	wg.Add(1)
	go sayAny("Hola guille", &wg)
	wg.Wait()
}
