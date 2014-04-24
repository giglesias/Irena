namespace IrenaWeb.Services
{
    using System;
    using System.Drawing.Imaging;
    using System.IO;
    using System.Web;
    using System.Web.Mvc;

    using IrenaWeb.Models;

    using Newtonsoft.Json;
    using ZXing;
    using ZXing.Common;

    public class QrCodeService : IQrCodeService
    {
        public IHtmlString GenerateRelayQrCode(HistoriaClinica medicalHistory, int height = 250, int width = 250, int margin = 0)
        {
            var medicalHistoryJson = JsonConvert.SerializeObject(medicalHistory);

            var barcodeWriter = new BarcodeWriter
            {
                Format = BarcodeFormat.QR_CODE,
                Options = new EncodingOptions
                {
                    Height = height,
                    Width = width,
                    Margin = margin
                }
            };

            using (var bitmap = barcodeWriter.Write(medicalHistoryJson))
            using (var stream = new MemoryStream())
            {
                bitmap.Save(stream, ImageFormat.Gif);

                var img = new TagBuilder("img");
                img.MergeAttribute("alt", "Su código QR no puede ser mostrado");
                img.Attributes.Add("src", string.Format("data:image/gif;base64,{0}",
                    Convert.ToBase64String(stream.ToArray())));

                return MvcHtmlString.Create(img.ToString(TagRenderMode.SelfClosing));
            }
        }
    }
}