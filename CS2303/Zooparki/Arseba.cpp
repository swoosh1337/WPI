#ifndef ARSEBA_CPP
#define ARSEBA_CPP


#include "Arseba.h"

//konstruqtorebi
Arseba::Arseba(){
	
}
Arseba::Arseba(int asaki, double wona){
	this -> asaki = asaki;
	this -> wona = wona;
}

//get da set funqciebi
int Arseba::getAsaki(){
	return asaki;
}
void Arseba::setAsaki(int asaki){
	this -> asaki = asaki;
}
double Arseba::getWona(){
	return wona;
}
void Arseba::setWona(double wona){
	this -> wona = wona;
}


#endif
