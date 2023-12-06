package main

import (
	"fmt"
)

type Carro struct {
	modelo int
	marca  string
}

func NewCarro() *Carro {
	return &Carro{}
}

func contadorVocales(frase string) (int, int, int, int, int) {
	conta := 0
	conte := 0
	conti := 0
	conto := 0
	contu := 0
	for _, valor := range frase {
		variable := string(valor)
		switch variable {
		case "a":
			conta++
		case "e":
			conte++
		case "i":
			conti++
		case "o":
			conto++
		case "u":
			contu++
		}
	}
	return conta, conte, conti, conto, contu
}

func main() {
	fmt.Println("Hello, World!")

	const pi float64 = 3.14159265
	const pi2 = 3.14159265

	base := 12
	var altura int = 14

	area := base * altura
	fmt.Println(area)

	frase := "Hola mundo en mi alineacion tecnica"
	a, e, _, o, u := contadorVocales(frase)
	fmt.Println("Vocales: ", a, e, o, u)
}
