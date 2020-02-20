void setup(){
  //fullScreen();
  size(1280,720 );  //width height
  background(0,0,255);
}

void draw(){
  fill(0,0,0);
 rect(width-(width-width/12),height - (height-height/25),width - (width-2*(width/12)) ,height - (height-2*(height/25))); 
 
 if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))){
   fill(255,0,0);
 rect(width-(width-width/12),height - (height-height/25),width - (width-2*(width/12)) ,height - (height-2*(height/25))); 
 }
}
//
// && (mouseY > height - 810) && mouseY < height -270
