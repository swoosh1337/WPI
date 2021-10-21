#ifndef FRINVELI_H
#define FRINVELI_H


#include "Arseba.cpp"

class Frinveli : public Arseba{
	protected:
		//velebi
		double frenisSichqare;
	
	public:
		//konstruqtorebi
		Frinveli();
		Frinveli(int, double, double );
		
		//get da set funqciebi
		double getSichqare();
		void setSichqare(double );
		
		//rogorc klasi Cxoveli igive mizzezis gamo esec avtomaturad abstraqtulia
		
		
		//wakitxvis funqcia
		void wakitxva(istream & );
		
		void bechdva(ostream &);
};

#endif
