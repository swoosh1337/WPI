#include <stdio.h>
#include <stdlib.h>
#include <iostream>

#include "Organism.h"
using namespace std;

Organism::Organism() {

}

/**Prints a dot ( . ) which represents a free space in the grid
 * @return void
 * */
void Organism::print(){
	cout<<".";
	return;
}
