    Mac OS X            	   2   F      x  	�osasToyS                         ATTR       x   x                         	8  8   z                                                                                                                                                                                                                                                   �<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict/>
</plist>
    � *]             C��    �<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict/>
</plist>
  �{\rtf1\ansi\ansicpg1252\cocoartf1187\cocoasubrtf340
{\fonttbl\f0\fnil\fcharset0 Verdana;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red64\green128\blue0;\red108\green5\blue211;
\red0\green22\blue176;\red0\green0\blue255;}
\pard\tx576\tx1152\tx1728\tx2304\tx2880\tx3456\tx4032\tx4608\tx5184\tx5760\tx6337\tx6913\tx7489\tx8065\tx8641\tx9217\tx9793\tx10369\tx10945\tx11521\tx12097\tx12674\tx13250\tx13826\tx14402\tx14978\tx15554\tx16130\tx16706\tx17282\tx17858\tx18435\tx19011\tx19587\tx20163\tx20739\tx21315\tx21891\tx22467\tx23043\tx23619\tx24195\tx24772\tx25348\tx25924\tx26500\tx27076\tx27652\tx28228\tx28804\tx29380\tx29956\tx30532\tx31109\tx31685\tx32261\tx32837\tx33413\tx33989\tx34565\tx35141\tx35717\tx36293\tx36870\tx37446\tx38022\tx38598\tx39174\tx39750\tx40326\tx40902\tx41478\tx42054\tx42630\tx43207\tx43783\tx44359\tx44935\tx45511\tx46087\tx46663\tx47239\tx47815\tx48391\tx48967\tx49544\tx50120\tx50696\tx51272\tx51848\tx52424\tx53000\tx53576\tx54152\tx54728\tx55305\tx55881\tx56457\tx57033\tx57609\li832\fi-833\pardirnatural

\f0\b\fs24 \cf2 \CocoaLigature0 set
\b0  \cf3 weather\cf2  
\b to
\b0  "curl " & \cf4 quote\cf2  & "http://weather.yahooapis.com/forecastrss?p=19717&u=f" & \cf4 quote\cf2 \
\

\b set
\b0  \cf3 postWeather\cf2  
\b to
\b0  "grep -E '(Current Conditions:|F<BR)'"\
\

\b set
\b0  \cf3 forecast\cf2  
\b to
\b0  
\b \cf5 do shell script
\b0 \cf2  \cf3 weather\cf2  & " | " & \cf3 postWeather\cf2 \
\

\b set
\b0  \cf3 statement\cf2  
\b to
\b0  (
\i \cf6 characters
\i0 \cf2  1 
\b through
\b0  -7 
\b of
\b0  
\i \cf6 paragraph
\i0 \cf2  2 
\b of
\b0  \cf3 forecast\cf2 ) 
\b as
\b0  
\i \cf6 string
\i0 \cf2 \
\

\b \cf5 say
\b0 \cf2  \cf3 statement}     	8  8   z   !     z ToyS  "WPos   :DPos   FRTF    R ���         ���   �     ���   �     ���   �    h��  �
   