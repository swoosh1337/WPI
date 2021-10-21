#ifndef BU_CPP
#define BU_CPP

#include "Bu.h"

Bu::Bu(){
	
}

Bu::Bu(int asaki, double wona, double frenisSichqare, int dzili) : Frinveli(asaki,wona,frenisSichqare){
	this -> dzili = dzili;
}

int Bu::getDzili(){
	return dzili;
}

void Bu::setDzili(int dzili){
	this -> dzili = dzili;
}

void Bu::arseboba(){
	cout<<"Bu cocxlobs"<<endl;
}


void Bu::busWakitxva(istream & is){
	wakitxva(is);
	is>>dzili;
}

void Bu::busBechdva(ostream & os){
	cout<<"informacia bus shesaxeb : "<<endl;
	cout<<"am bus dge-gamis ganmavlobashi dzinavs "<<dzili<<"saati, ";
	bechdva(os);
}

#endif
