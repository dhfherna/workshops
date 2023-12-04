package main

import (
	"fmt"
)

func mensaje(text string, c chan string) {
	c <- text
}

func main() {
	email1 := make(chan string)
	email2 := make(chan string)

	go mensaje("Hola", email1)
	go mensaje("Mundo", email2)

	for i := 0; i < 2; i++ {
		select {
		case m1 := <-email1:
			fmt.Println("Email recibido de email1", m1)
		case m2 := <-email2:
			fmt.Println("Email recibido de email2", m2)
		}
	}
}
