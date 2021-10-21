#ifndef CXOVELI_CPP
#define CXOVELI_CPP



#include "Cxoveli.h"

//konstruqtorebi
Cxoveli::Cxoveli(){
	
}
//parametriani konstruqtori idzaxebs mshoblis konstruqtors garkveuli velebistvis
Cxoveli::Cxoveli(int asaki, double wona, string bunebriviSacxovrebeliAdgili) : Arseba(asaki,wona){
	this -> bunebriviSacxovrebeliAdgili = bunebriviSacxovrebeliAdgili;
}

//get da set funqciebi
string Cxoveli::getAdgili(){
	return bunebriviSacxovrebeliAdgili;
}
void Cxoveli::setAdgili(string bunebriviSacxovrebeliAdgili){
	this -> bunebriviSacxovrebeliAdgili = bunebriviSacxovrebeliAdgili;
}

//wakitxvis funqcia
void Cxoveli::wakitxva(istream &is){
	is>>asaki>>wona>>bunebriviSacxovrebeliAdgili;
}

void Cxoveli::bechdva(ostream & os){
	os<<"misi asaki aris - "<<asaki<<", is aris "<<wona<<" kilogrami. misi bunebrivi sacxovrebeli adgilia - "<<bunebriviSacxovrebeliAdgili<<endl;
}

#endif
