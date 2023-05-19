@echo off
setlocal
set Zip="C:\Program Files\Tools\7-Zip\7z.exe"

set PrjDir=D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.vis
set BldDir=%PrjDir%\dev\vis

set SrcDir=%BldDir%\dist
set OutZip=%PrjDir%\liveview\client.zip

@echo on
cd /d %SrcDir%
del %OutZip%
%Zip% a %OutZip%

pause
