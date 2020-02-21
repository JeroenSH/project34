String menu = "eerstekeuze";
void setup() {
  //fullScreen();
  size(1280, 720 );  //width height
  background(0, 0, 255);
}
/*
alle blokken
 
 fill(0, 0, 0);
 rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 1 linksboven
 
 fill(0,0,0);
 rect(width-(3*(width/12)), height - (height-height/25),width - (width-(2*(width/12))) , height - (height-2*(height/25)));   //blok 2 rechtsboven
 
 fill(0, 0, 0);
 rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 3 linksonder
 
 fill (0,0,0);
 rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder
 */


void draw() {

  switch(menu) {
  case "welkom":
    break;
  case "eerstekeuze":
    background(0, 0, 255);
    fill(0, 0, 0);
    rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 1 linksboven

    fill(0, 0, 0);
    rect(width-(3*(width/12)), height - (height-height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 2 rechtsboven

    fill(0, 0, 0);
    rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 3 linksonder

    fill (0, 0, 0);
    rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder


    if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))) {    //blok 1
      fill(255, 0, 0);
      rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25))); 
      if (mousePressed == true) {
        menu ="geef pincode";
      }
    }
    if ((mouseX > (width -(3*(width/12)))) && mouseX < (width - (width/12)) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))) {    //blok 2
      fill(0, 255, 0);
      rect(width-(3*(width/12)), height - (height-height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="geef pincode";
      }
    }
     //&& mouseY < height-(3*(height/25))
     if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && mouseY > (height/25) && mouseY < height/25) {    //blok 3 // mouseY nog aanpassen
      fill(0, 255, 0);
       rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="geef pincode";
      }
    }
    break;
  case "geef pincode":
    background(255, 0, 0);
    break;
  }
}
