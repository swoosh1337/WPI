#ifndef CXOVELI_H
#define CXOVELI_H


#include "Arseba.cpp"
using namespace std;

class Cxoveli : public Arseba{
	protected:
		//velebi
		string bunebriviSacxovrebeliAdgili;
	
	public:
		//konstruqtorebi
		Cxoveli();
		Cxoveli(int, double, string );
		
		//get da set funqciebi
		string getAdgili();
		void setAdgili(string );
		
		//radganac mshoblis sufta virtualuri funqcia "virtual void arseboba()" ar gadvsazgvret
		//es klasic avtomaturad gamocxadda abstraqtulad.
		
		//wakitxvis fuqncia
		void wakitxva(istream &);
		
		void bechdva(ostream &);
	
};

#endif
