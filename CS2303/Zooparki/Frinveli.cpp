#ifndef FRINVELI_CPP
#define FRINVELI_CPP


#include "Frinveli.h"

//konstruqtorebi
Frinveli::Frinveli(){
	
}
//vidzaxebt mshoblis konstruqtors
Frinveli::Frinveli(int asaki, double wona, double frenisSichqare) : Arseba(asaki,wona){
	this -> frenisSichqare = frenisSichqare;
}

//get da set funqciebi
double Frinveli::getSichqare(){
	return frenisSichqare;
}
void Frinveli::setSichqare(double frenisSichqare){
	this -> frenisSichqare = frenisSichqare;
}


//wakitxivs fuqncia
void Frinveli::wakitxva(istream & is){
	is>>asaki>>wona>>frenisSichqare;
}

//bechdvis funqcia
void Frinveli::bechdva(ostream & os){
	os<<"is aris "<<asaki<<" wlis, iwonis "<<wona<<" kilograms. "<<"misma maqsimalurma sichqarem sheidzleba miagwios "<<frenisSichqare<<" km/st-s."<<endl;
	
}

#endif
