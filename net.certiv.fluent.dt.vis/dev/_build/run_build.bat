@echo off

setlocal
set PrjDir=D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.vis
set BldDir=%PrjDir%\dev\liveview

cd /d %BldDir%
npm run build



