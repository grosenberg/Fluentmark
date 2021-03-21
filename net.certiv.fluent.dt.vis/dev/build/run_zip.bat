@echo off

setlocal
set Zip="C:\Program Files\Tools\7-Zip\7z.exe"

set PrjDir=D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.vis
set SrcDir=%PrjDir%\dev\liveview\dist
set OutZip=%PrjDir%\liveview\client.zip

cd /d %SrcDir%
del %OutZip%
%Zip% a %OutZip%
