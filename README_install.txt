Fedora 42
---------

sudo dnf install R
sudo dnf install cmake
sudo dnf install libcurl-devel freetype-devel libpng-devel libtiff-devel libjpeg-devel libwebp-devel

R -q -e "install.packages(c('DSI', 'DSOpal'), dependencies = TRUE)"

R -q -e "remotes::install_github(repo = 'datashield/dsBaseClient', ref = '6.3.4', dependencies = TRUE)"
