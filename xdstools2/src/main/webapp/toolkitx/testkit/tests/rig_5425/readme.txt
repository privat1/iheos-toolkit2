Unknown DICOM UIDs, Single IDS

<h2>Unknown DICOM UIDs, Single IDS</h2>

<p/>Tests the ability of the Responding Imaging Gateway actor (SUT) to respond
correctly to a Cross Gateway Retrieve Imaging Document Set (RAD-75) transaction
from an Initiating Imaging Gateway actor (Simulator), for a single DICOM image
file, in the case where the Image Document Source has no image with matching 
DICOM UID values.

<p/>The DICOM UIDs in the RAD-69 request do not refer to an image that is known
to the Imaging Document Source, and an error code will be returned by the
Imaging Document Source to the Responding Imaging Gateway.

<h3>Retrieve Parameters</h3>
<table border="1">
 <tr><td>RIG Home Community ID</td><td>urn:oid:1.3.6.1.4.1.21367.13.70.201</td></tr>
 <tr><td>IDS Repository Unique ID (E)</td><td>1.3.6.1.4.1.21367.13.71.201.1</td></tr>
 <tr><td>Transfer Syntax UID</td><td>1.2.840.10008.1.2.1</td></tr>
</table>