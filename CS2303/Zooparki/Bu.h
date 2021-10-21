#ifndef BU_H
#define BU_H

#include "Frinveli.cpp"

class Bu : public Frinveli{
	protected:
		int dzili;
		
	public:
		Bu();
		Bu(int, double, double, int);
		
		int getDzili();
		void setDzili(int );
		
		void arseboba();
		
		//wakitxivs funqcia
		void busWakitxva(istream &);
		
		void busBechdva(ostream &);
};

#endif
