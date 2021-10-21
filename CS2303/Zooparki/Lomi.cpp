#ifndef LOMI_CPP
#define LOMI_CPP

#include "Lomi.h"

Lomi::Lomi(){
	
}

Lomi::Lomi(int asaki, double wona, string sacxovrebeli, string saxeoba) : Cxoveli(asaki,wona,sacxovrebeli){
	this -> saxeoba = saxeoba;
}

string Lomi::getSaxeoba(){
	return saxeoba;
}

void Lomi::setSaxeoba(string saxeobsa){
	this -> saxeoba = saxeoba;
}

void Lomi::arseboba(){
	cout<<"lomi cocxlobs"<<endl;
}

// >> gadatvirtva
istream & operator>> (istream & is , Lomi & l){
	l.wakitxva(is);
	is>>l.saxeoba;
	return is;
}

// << gadatvirtva
ostream & operator<< (ostream & os , Lomi & l){
	os<<"informacia lomis shesaxeb : "<<endl;
	os<<"es lomi aris "<<l.getSaxeoba()<<" saxeobis, ";
	l.bechdva(os);
	return os;
}

#endif
