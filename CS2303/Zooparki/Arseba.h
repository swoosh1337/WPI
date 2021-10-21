#ifndef ARSEBA_H
#define ARSEBA_H


#include <iostream>
#include <string>
#include <fstream>


using namespace std;
class Arseba{
	protected:
		//velebi
		int asaki;
		double wona;
			
	public:
		//konstruqtorebi
		Arseba();
		Arseba (int, double);
		
		//get da set funqciebi
		int getAsaki();
		void setAsaki(int );
		double getWona();
		void setWona(double );
		
		//sufta virtualuri funqcia romelic klass abstraqtuls gaaxdens.
		virtual void arseboba() = 0;
		
};

#endif
